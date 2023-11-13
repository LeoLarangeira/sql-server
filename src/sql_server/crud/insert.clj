(ns sql-server.crud.insert
  (:require [honeysql.format :as honey]
            [honeysql.core :as sql]
            [clojure.java.jdbc :as jdbc] 
            [sql-server.components.db :as db])) 

#_(honey/format {:insert-into :user
                 :values [{:name name
                           :email email
                           :address address}]})




#_(defn insert-users! [name email address]
  (jdbc/db-do-commands db/db "insert into user (name,email, address)
                                                                                  values ('Leo','teste@mail.com','outro endereco')"
                        ))

(defn insert-user! [name email address]
  (jdbc/execute! db/db
                 ["INSERT INTO user (name, email, address) VALUES (?, ?, ?)"
                  name email address]))

#_(insert-user "John" "john@example.com" "123 Main St")
;(insert-users! "leo" "test@mail.com" "outro endereco")