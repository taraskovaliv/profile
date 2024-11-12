docker system prune -a -f
git pull --rebase
sudo docker compose build
sudo docker image tag profile-api:latest registry.localhost/profile-api:latest
sudo docker push --tls-verify=false registry.localhost/profile-api:latest
sudo kubectl apply -f kuber/profile.yaml
