(defproject uklala "0.1.0-SNAPSHOT"
  :description "a little IM app"
  :url "https://github.com/jsckdao/uklala"
  :license "Eclipse Public License 1.0"
  :min-lein-version "2.0.0"
  ;; :dependencies [[org.clojure/clojure "1.6.0"]
  ;;                [compojure "1.3.1"]
  ;;                [ring/ring-defaults "0.1.2"]]
  ;; :plugins [[lein-ring "0.8.13"]]
  ;; :ring {:handler uklala.handler/app}
  ;; :profiles
  ;; {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
  ;;                       [ring-mock "0.1.5"]]}})
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [http-kit "2.1.18"]]
  :main uklala.boot
  )
