variable "prefix" {
  default = "k8s"
}

variable "location" {
  default = "koreacentral"
}

variable "admin_username" {
  default = "azureuser"
}

variable "ssh_public_key" {
  default = "C:/Users/이문영/.ssh/id_rsa_azure.pub"
}

variable "vm_size" {
  default = "Standard_D2s_v5"
}

variable "worker_count" {
  default = 2
}

variable "master_count" {
  default = 1
}