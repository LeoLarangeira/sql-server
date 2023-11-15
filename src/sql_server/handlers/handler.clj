(ns sql-server.handlers.handler
  (:require [compojure.core :refer :all]
            [sql-server.crud.insert :as i]
            [sql-server.crud.update :as up]
            [sql-server.crud.delete :as del]
            [sql-server.crud.search :as sc]
            [cheshire.core :refer :all]
            [faker.name :as fkn]
            [faker.address :as fka]
            [clojure.java.jdbc :as jdbc]
            [sql-server.crud.search :as search]))

(def user-name (fkn/first-name))  ; Assuming fkn is a namespace for functions related to first names
(def email (str user-name "@teste.com"))
(def address (fka/street-address))  ; Assuming fka is a namespace for functions related to street addresses

(defn create-user []
  ; This function will receive a request from routes and return a map with the new user
  (let [user (i/insert-user! user-name email address) 
        user-string (generate-string user)]
    {:status 200
     :headers {"Content-Type" "application/json; charset=utf-8"}
     :body (str "Usuário inserido com sucesso, temos um total de:" 1 " usuarios")}))

(defn delete-user [id]
  ; This function will receive the id from the user and will delete them
  (let [deleted-user (del/delete-user! id)]
    {:status 200
     :headers {"Content-Type" "application/json; charset=utf-8"}
     :body (str "Usuário deletado com sucesso")}))

(defn uptade-user-name [id name]
  ; This function will update the user's name based on the provided id
  (let [update-user (up/update-user! id name)
        new-user (search/get-user-id id)]
    {:status 200
     :headers {"Content-Type" "application/json; charset=utf-8"}
     :body new-user}))


(defn search-user [id]
  (println id)
  (let [user (sc/get-user-dto-id id)
        _ (println "user->" user)
        _ (println "type->" (type user))
        str-convert (str user)
        _ (println "convert->" str-convert)
        _ (println "convert->type" (type str-convert))]
    {
     :status 200
     :body str-convert
    }))