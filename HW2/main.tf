locals {
  infra_env = terraform.workspace == "default" ? "Dev" : terraform.workspace
}

module "wepServer-dev" {
  source = "./modules/DevModule"
}

module "wepServer-prod" {
  source = "./modules/ProdModule"
}

resource "google_compute_instance_template" "flask-server-template" {
  name = "flask-app-template"
  description = "This template is used for creating compute instances to run flask web app."

  labels = {
    environment = local.infra_env == "Production" ? "production" : "dev"
  }

  machine_type = "c2-standard-4"  // 4 vCPU and 16 GB memory (compute optimized machine)
  can_ip_forward = false

  disk {
    source_image      = "debian-cloud/debian-9"
    auto_delete       = true
    boot              = true
  }

  network_interface {
    network = "default"
    subnetwork = "default"
  }

}

resource "google_compute_instance_group_manager" "appserver" {
  name = "appserver-igm"

  base_instance_name = "appserver"
  zone = "us-central1-a"

  target_size  = 1    # at least 1 VM instance

  version {
    instance_template = google_compute_instance_template.flask-server-template.id
  }
}
