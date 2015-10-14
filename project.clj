(defproject marick/suchwow "4.4.0"
  :description "Such functions! Such doc strings! Much utility!"
  :url "https://github.com/marick/suchwow"
  :pedantic? :warn
  :license {:name "The Unlicense"
            :url "http://unlicense.org/"
            :distribution :repo}

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [potemkin "0.4.1" :exclusions [org.clojure/clojure]]
                 [com.rpl/specter "0.8.0" :exclusions [org.clojure/clojure org.clojure/clojurescript]]
                 [environ "1.0.1" :exclusions [org.clojure/clojure]]
                 [commons-codec/commons-codec "1.10"]]

  :repl-options {:init (do (require 'such.doc)
                           (such.doc/apis))}

  :profiles {:dev {:dependencies [[midje "1.8-alpha1" :exclusions [org.clojure/clojure]]
                                  [org.clojure/math.combinatorics "0.1.1"]
                                  [org.clojure/data.json "0.2.6"]]}
             :1.5.0 {:dependencies [[org.clojure/clojure "1.5.0"]]}
             :1.5.1 {:dependencies [[org.clojure/clojure "1.5.1"]]}
             :1.6 {:dependencies [[org.clojure/clojure "1.6.0"]]}
             :1.7 {:dependencies [[org.clojure/clojure "1.7.0"]]}
             :1.8 {:dependencies [[org.clojure/clojure "1.8.0-beta1"]]}
             }

  :plugins [[lein-midje "3.2-RC4"]
            [codox "0.8.11"]]

  :codox {:src-dir-uri "https://github.com/marick/suchwow/blob/master/"
          :src-linenum-anchor-prefix "L"
          :output-dir "/var/tmp/suchwow-doc"
          :defaults {:doc/format :markdown}}

  :aliases {"compatibility" ["with-profile" "+1.5.0:+1.5.1:+1.6:+1.7:+1.8" "midje" ":config" ".compatibility-test-config"]
            "travis" ["with-profile" "+1.5.0:+1.5.1:+1.6:+1.7:+1.8" "midje"]}

  ;; For Clojure snapshots
  :repositories {"sonatype-oss-public" "https://oss.sonatype.org/content/groups/public/"}
  :deploy-repositories [["releases" :clojars]]
)
