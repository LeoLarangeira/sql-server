(ns sql-server.components.db
  (:require [clojure.java.jdbc :as jdbc]))



;interessante que no linux roda liso né 
;nota de ódio: Essa merda não roda no windows. Vou vender essa bomba de notebook
(def db "jdbc:sqlite::memory")

(declare db)

(defn start-db []
  (let [spec {:connection-uri db}
        conn (jdbc/get-connection spec)]
    (assoc spec :connection conn))
  (jdbc/db-do-commands db "CREATE TABLE IF NOT EXISTS user (
    id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    name TEXT NOT NULL,
    email TEXT NOT NULL,
    address TEXT NOT NULL 
);" )
  )




(defn stop-db []
  (-> db :connection .close)
  nil)