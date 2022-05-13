terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
      version = "4.20.0"
    }
  }
}

provider "google" {
  # configuration options
  project = "peppy-oven-344513"
  region = "us-central1"
  zone = "us-central1-a"
  credentials = "my_key.json"
}
