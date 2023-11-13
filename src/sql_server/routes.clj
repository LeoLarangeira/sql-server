(ns sql-server.routes
  (:require [compojure.core :refer [GET POST PUT DELETE defroutes]]
            [compojure.route :as route]
            [sql-server.crud.search :as search]
            [sql-server.crud.update :as up]
            [sql-server.handlers.handler :as handler]))



(defroutes routes
  (GET "/users" [req] "<h1> retorna os 5 primeiros usuários </h1>"
    (search/get-five-users )) 
  (POST "/users"[req] "<h1> cria um usuário aleatório<h1>"
    (handler/create-user))
  (PUT "/users/:id/:name" [id name] "<h1> insira o id do seu usuário e depois o novo nome </h1>"
    (up/update-user! id name))
  (DELETE "users/:id" [id] "<h1> deleta a partir do id </h1>")
  (route/not-found "<h1> Não conseguir achar </h1>"))