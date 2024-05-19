#!/bin/bash

nohup java -jar /root/HospitalSystem/software-engineering/hospital-backend/target/HospitalApi-1.0-SNAPSHOT.jar &
cd /root/HospitalSystem/software-engineering/hospital-frontend
nohup /root/node-v16.13.2-linux-x64/bin/node /root/HospitalSystem/software-engineering/hospital-frontend/node_modules/.bin/vue-cli-service serve &

