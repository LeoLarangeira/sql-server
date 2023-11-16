(ns sql-server.components.db
  (:require [clojure.java.jdbc :as jdbc]))



(def db "jdbc:sqlite::memory")  ; Database connection URI, using an in-memory SQLite database

(declare db)

(defn start-db []
  ; This function initializes and starts an in-memory SQLite database.
  (let [spec {:connection-uri db}
        conn (jdbc/get-connection spec)]
    (assoc spec :connection conn))  ; Associates the database connection with the spec map

  (jdbc/db-do-commands db "CREATE TABLE IF NOT EXISTS user (
    id_user INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    name TEXT NOT NULL,
    email TEXT NOT NULL,
    address TEXT NOT NULL 
);")  ; Executes a command to create the 'user' table if it doesn't exist
  )

(defn stop-db []
  ; This function stops and closes the database connection.
  (-> db :connection .close)  ; Closes the database connection
  nil  ; Returns nil after closing the connection
  )
