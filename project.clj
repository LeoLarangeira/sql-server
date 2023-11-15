(defproject sql-server "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [cheshire "5.12.0"]
                 [compojure "1.6.1"]
                 [com.brunobonacci/mulog "0.9.0"]
                 [ring/ring-defaults "0.3.2"]
                 [ring/ring-jetty-adapter "1.9.6"]
                 [org.xerial/sqlite-jdbc "3.42.0.0"] 
                 [org.clojure/java.jdbc "0.7.12"]
                 [honeysql "1.0.461"]
                 [faker "0.3.2"]]
  :main ^:skip-aot sql-server.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
