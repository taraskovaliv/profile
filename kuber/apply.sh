docker system prune -a -f
git pull --rebase
sudo docker compose build -t reg.local/profile-api:latest
sudo kubectl apply -f kuber/profile.yaml
