cd C:\Users\a844017\UPGRADE\microservices-jwt\config-service\
start cmd /k call run-console.bat
timeout /t 10
cd..
cd C:\Users\a844017\UPGRADE\microservices-jwt\eureka-service\
start cmd /k call run-console.bat
timeout /t 20
cd..
cd C:\Users\a844017\UPGRADE\microservices-jwt\bike-service\
start cmd /k call run-console.bat
timeout /t 15
cd..
cd C:\Users\a844017\UPGRADE\microservices-jwt\car-service\
start cmd /k call run-console.bat
timeout /t 15
cd..
cd C:\Users\a844017\UPGRADE\microservices-jwt\user-service\
start cmd /k call run-console.bat
exit