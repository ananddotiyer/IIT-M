Open Ubuntu22.04.2 LTS.  It'll install OS.

curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.39.0/install.sh | bash

nvm install --lts

node --version (v18.16.0)

npm --version (9.5.1)

npm install -g @vue/cli

npm install vue-router@next

npm install vuex

npm install bootstrap

vue --version(@vue/cli 5.0.8)

vue create <project>

npm run serve

## In order to kill hanging ports, run the following commands:
sudo lsof -i :8080
kill -9 <PID>

## In order to debug in console, use
$vm.data.<attribute>

