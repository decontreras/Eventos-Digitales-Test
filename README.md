## Prueba tecnica lider
El proyecto se encuentra dockerizado, si desea correrlo sin docker debe tener instalado mysql y java-jdk-8

## arrancar proyecto back con docker
```bash
docker-compose up -d
```

## arrancar proyecto front con docker
```bash
docker image build -t event-front .
docker run -d -p 80:80 --rm  event-front
```

## programa
El programa gestiona eventos de la compañía, con la finalidad de llevar un seguimiento de presupuesto anual por plataforma.