locals {
  infra_env = terraform.workspace == "default" ? "Dev" : terraform.workspace
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
    source_image      = "flask-app-image"
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

  version {
    instance_template = google_compute_instance_template.flask-server-template.id

    target_size {
      fixed = 1   // at least one VM is running in the group
    }

  }
}
