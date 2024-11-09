docker system prune -a -f
git pull --rebase
sudo docker compose build
sudo docker save profile-api | k3s ctr images import -
sudo kubectl apply -f kuber/profile.yaml
