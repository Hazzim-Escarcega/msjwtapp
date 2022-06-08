cd config-service
start cmd /k call run-console.bat
timeout /t 15
cd..
cd eureka-service
start cmd /k call run-console.bat
timeout /t 20
cd..
cd gateway-service
start cmd /k call run-console.bat
timeout /t 15
cd..
cd bike-service
start cmd /k call run-console.bat
timeout /t 15
cd..
cd car-service
start cmd /k call run-console.bat
timeout /t 15
cd..
cd user-service
start cmd /k call run-console.bat
exit