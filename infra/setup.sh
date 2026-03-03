#!/bin/bash
sudo yum update -y
sudo amazon-linux-extras install docker -y
sudo service docker start
sudo usermod -a -G docker ec2-user
sudo yum install git -y
git clone https://github.com/Danielgelsdorf/api-preco-acoes.git /home/ec2-user/app
cd /home/ec2-user/app
sudo docker build -t api-acoes .
sudo docker run -d -p 80:80 --name api-rodando api-acoes