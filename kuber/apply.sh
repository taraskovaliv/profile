docker build . -t taras_kovaliv/profile -f ../../Dockerfile
sudo kubectl apply -f profile.yaml