(ns sql-server.crud.create
  (:require [clojure.java.jdbc :as jdbc]
            [sql-server.components.db :as db]
            [honeysql.format :as honey]))


(defn create-tables [db]
  
  (let [query (str "create table if not exists user(
                    id_user int not null primary-key autoincrement,
                    name text not null,
                    email text not null,
                    address text not null,
  )" )]
    (jdbc/db-do-commands db query))
  )


