# Build Stage 1
# This build created a staging docker image
#
FROM node:lts-alpine AS build
WORKDIR /usr/src/app
COPY package.json ./
COPY tsconfig.json ./
RUN npm install
COPY ./src ./src
RUN npm run build

# Build Stage 2
# This build takes the production build from staging build
#
FROM node:lts-alpine
ARG NODE_ENV=production
WORKDIR /usr/src/app
COPY package.json ./
RUN npm install
COPY --from=build /usr/src/app/dist ./dist
EXPOSE 3000
CMD npm start:prod