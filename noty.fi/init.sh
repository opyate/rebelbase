#!/bin/bash
IP=$(cat IP)
echo "Copying public key to $IP"
ssh root@$IP "mkdir -p ~/.ssh"
if [ -x /usr/bin/ssh-copy-id ]
then
  ssh-copy-id -i ~/.ssh/id_rsa.pub root@$IP
else
  scp ~/.ssh/id_rsa.pub root@$IP:~/.ssh/authorized_keys
fi
