(ns sql-server.core
  (:gen-class)
  (:require [sql-server.components.db :as db]
            [sql-server.routes :as r]
            [ring.adapter.jetty :as jetty]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (db/start-db) 
  (jetty/run-jetty r/routes {:port 8000
                             :join? true
                             :daemon? true})
  (println "Hello, World!")
  (db/stop-db))
