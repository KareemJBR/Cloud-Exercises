terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
      version = "4.20.0"
    }
  }

  backend "http" {
    address = "http://peppy-oven-344513/flask-app.com/foo"
    lock_address = "http://peppy-oven-344513/flask-app.com/foo"
    unlock_address = "http://peppy-oven-344513/flask-app.com/foo"
    update_method = "PUT"
  }
}

provider "google" {
  # configuration options
  project = "peppy-oven-344513"
  region = "us-central1"
  zone = "us-central1-a"
  credentials = "my_key.json"
}
