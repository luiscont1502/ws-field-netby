# ws-field-netby
# Este proyecto esta realizado con Java 17 y spring boot 3.2.6
Ejercicio 2
Resultados de la salida 
dentro de las condiciones dadas no se puede obtener la salida especificada en el documento ya que no esta considerando 2 condicionees la cual es 
la conferencia de debe ser despues de las 4 y antes de las 5 y en la salida del docuemnto enviado  esta a las 5 pm 
En el documento enviado no se considera la charla de 5 minutos .
 Resultados 
 En este ejecicio se implementa las condiciones descritas para la resolucion del problema
 Para la obtencion de resultados se considera una salida generica siguiendo el concepto de Graphql

CURL DE EJECUCION
curl --request POST \
--url http://127.0.0.1:8080/api/schedule \
--header 'Content-Type: application/json' \
--header 'User-Agent: insomnia/2023.5.8' \
--data '[
"Writing Fast Tests Against Enterprise Rails 60min",
"Overdoing it in Python 45min",
"Lua for the Masses 30min",
"Ruby Errors from Mismatched Gem Versions 45min",
"Common Ruby Errors 45min",
"Rails for Python Developers lightning",
"Communicating Over Distance 60min",
"Accounting-Driven Development 45min",
"Woah 30min",
"Sit Down and Write 30min",
"Pair Programming vs Noise 45min",
"Rails Magic 60min",
"Ruby on Rails: Why We Should Move On 60min",
"Clojure Ate Scala (on my project) 45min",
"Programming in the Boondocks of Seattle 30min",
"Ruby vs. Clojure for Back-End Development 30min",
"Ruby on Rails Legacy App Maintenance 60min",
"A World Without HackerNews 30min",
"User Interface CSS in Rails Apps 30min"
]
'