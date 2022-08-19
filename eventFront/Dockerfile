#stage 1
FROM node:latest as node

ARG MAX_OLD_SPACE_SIZE=4096
ARG NPM_TOKEN
ENV NODE_OPTIONS=--max-old-space-size=${MAX_OLD_SPACE_SIZE}


WORKDIR /app
COPY . .
RUN npm install
RUN npm run build --prod
#stage 2
FROM nginx:alpine
COPY --from=node /app/dist/event-front /usr/share/nginx/html