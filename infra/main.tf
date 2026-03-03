resource "aws_instance" "api_server" {
  ami           = var.instancia_ami
  instance_type = var.instancia_tipo

  # Aqui o Terraform lê o arquivo setup.sh automaticamente
  user_data = file("${path.module}/setup.sh")

  tags = {
    Name = "API-Acoes-${var.ambiente}"
  }
}