cd ..

cd myshop-dependencies
call mvn clean package deploy
cd ..

cd myshop-commons
call mvn clean package
call mvn deploy
cd ..

cd myshop-commons-domain
call mvn clean package deploy
cd ..

cd myshop-commons-dubbo
call mvn clean package deploy
cd ..

cd myshop-commons-mapper
call mvn clean package deploy
cd ..

cd myshop-service-user-api
call mvn clean package deploy
cd ..

cd myshop-service-content-api
call mvn clean package deploy
cd ..

cd myshop-service-search-api
call mvn clean package deploy
cd ..

cd myshop-static-backend
call mvn clean package deploy
cd ..