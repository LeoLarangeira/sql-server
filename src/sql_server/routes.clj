(ns sql-server.routes
  (:require [compojure.core :refer [GET POST PUT DELETE defroutes]]
            [compojure.route :as route]))



(defroutes routes
  (GET "/users" [req] "<h1> retorna os 5 primeiros usuários </h1>") 
  (POST "/users"[req] "<h1> cria um usuário aleatório<h1>")
  (PUT "/users/:id/:name" [id name] "<h1> insira o id do seu usuário e depois o novo nome </h1>")
  (DELETE "users/:id" [id] "<h1> deleta a partir do id </h1>")
  (route/not-found "<h1> Não conseguir achar </h1>"))