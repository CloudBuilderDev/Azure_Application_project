output "master_public_ip" {
  value = azurerm_public_ip.master_ip.ip_address
}

output "acr_login_server" {
  value = azurerm_container_registry.acr.login_server
}
