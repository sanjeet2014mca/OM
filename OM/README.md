# Running

## Start SQL Server

```sh
docker run -it --rm -e SA_PASSWORD=Secret1234 -e ACCEPT_EULA=Y -v /tmp/mssql_linux:/var/opt/mssql -p 1433:1433 microsoft/mssql-server-linux
```

## Start web server

```sh
./gradlew run
```

# Usage

## Write
```sh
curl -XPUT -H "Content-Type:application/json" -d '{"firstName":"fawad", "lastName": "Halim"}' http://localhost:8089/people/1
```

## Read

```sh
curl http://localhost:8089/people/1
```

## Delete

```sh
curl -XDELETE http://localhost:8089/people/1
```
