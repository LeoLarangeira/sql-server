(ns sql-server.components.db
  (:require [clojure.java.jdbc :as jdbc]))



;interessante que no linux roda liso né 
;nota de ódio: Essa merda não roda no windows. Vou vender essa bomba de notebook
(def db "jdbc:sqlite::memory")

(declare db)

(defn start-db []
  (let [spec {:connection-uri db}
        conn (jdbc/get-connection spec)]
    (assoc spec :connection conn)))




(defn stop-db []
  (-> db :connection .close)
  nil)