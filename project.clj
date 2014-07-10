(defproject om-hello-world "0.1.0-SNAPSHOT"
  :description ""
  :url ""

  :jvm-opts ^:replace ["-Xmx1g" "-server"]

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2261"]
                 [org.clojure/core.async "0.1.303.0-886421-alpha"]
                 [secretary "0.4.0"]
                 [om "0.6.3"]
                 [ring "1.2.1"]
                 [compojure "1.1.6"]
                 [enlive "1.1.5"]]

  :plugins [[com.cemerick/austin "0.1.4"] [lein-cljsbuild "1.0.3"]]
  :repl-options {
                 :init-ns helloworld.bcrepl
                 }
  :source-paths ["src" "src-clj"]

  :cljsbuild { 
    :builds [{:id "dev"
              :source-paths ["src"]
              :compiler {
                :output-to "resources/public/app.js"
                :output-dir "resources/public/out"
                :optimizations :none
                :source-map true}}
             {:id "release"
              :source-paths ["src"]
              :compiler {
                :output-to "app.js"
                :optimizations :advanced
                :elide-asserts true
                :pretty-print false
                :output-wrapper false
                :preamble ["react/react.min.js"]
                :externs ["react/externs/react.js"]}}]})
