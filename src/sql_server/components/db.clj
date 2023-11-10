(ns sql-server.components.db
  (:require [clojure.java.jdbc :as jdbc]))

(def db "jdbc:sqlite::memory")
(declare db)

(defn start-db []
  (let [spec {:connection-uri db}
        conn (jdbc/get-connection spec)]
    (assoc spec :connection conn)))




(defn stop-db []
  (-> db :connection .close)
  nil)