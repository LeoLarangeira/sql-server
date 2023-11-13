(ns sql-server.handlers.handler
  (:require [compojure.core :refer :all]
            [sql-server.crud.insert :as i]
            [sql-server.crud.update :as up]
            [cheshire.core :refer :all]
            [faker.name :as fkn]
            [faker.address :as fka]
            [clojure.java.jdbc :as jdbc]
            [sql-server.crud.search :as search]))

(def user-name (fkn/first-name))
(def email (str user-name "@teste.com"))
(def address (fka/street-address))


(defn create-user []
  ;this function will recieve the req from routes and return a map with the new user
  (let [user (i/insert-user! user-name email address )
        _ (println "user" user)
        user-string (generate-string user)
        _ (println "user sting "user-string)]
    {
     :status 200
     :headers  {"Content-Type" "application/json; charset=utf-8"}
     :body (str "Usuário inserido com sucesso, temos um total de:" 1 " usuarios")
    })
  )

(defn delete-user [id]
  ;this function will receive the id from the user and  will delete him
  )

(defn uptade-user-name [id name]
  (let [update-user (up/update-user! id name)
        new-user (search/get-user-id id)]
    
    
    {:status 200
     :headers  {"Content-Type" "application/json; charset=utf-8"}
     :body new-user})
  )

(defn get-all-user []
  ;this function will return all the 5 first users
  )