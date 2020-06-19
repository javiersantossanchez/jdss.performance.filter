#!/bin/bash


docker-compose -f  docker-compose-monitoring-connector.yaml  -f docker-compose-monitoring-stack.yaml -f docker-compose-monitoring-target.yaml up -d elasticsearch kibana
x=0
echo 'start'
while [ $x -eq 0 ]
do
  echo 'asdasds'
  x=$(curl -i --silent  http://localhost:9200  | grep -w  -c "HTTP\|name" )
  echo '$x'
done


curl -X PUT http://localhost:9200/performance.monitoring -H "Content-Type: application/json"  -d '{"mappings": {"properties": {"@timestamp": {"type": "date"},"@version": {
        "type": "text","fields": {"keyword": {
            "type": "keyword",
            "ignore_above": 256
          }
        }
      },
      "date": {
        "type": "text",
        "fields": {
          "keyword": {
            "type": "keyword",
            "ignore_above": 256
          }
        }
      },
      "host": {
        "type": "text",
        "fields": {
          "keyword": {
            "type": "keyword",
            "ignore_above": 256
          }
        }
      },
      "httpMethod": {
        "type": "text",
        "fields": {
          "keyword": {
            "type": "keyword",
            "ignore_above": 256
          }
        }
      },
      "httpStatus": {
        "type": "text",
        "fields": {
          "keyword": {
            "type": "keyword",
            "ignore_above": 256
          }
        }
      },
      "ipClient": {
        "type": "ip",
        "fields": {
          "keyword": {
            "type": "keyword",
            "ignore_above": 256
          }
        }
      },
      "logLevel": {
        "type": "text",
        "fields": {
          "keyword": {
            "type": "keyword",
            "ignore_above": 256
          }
        }
      },
      "message": {
        "type": "text",
        "fields": {
          "keyword": {
            "type": "keyword",
            "ignore_above": 256
          }
        }
      },
      "path": {
        "type": "text",
        "fields": {
          "keyword": {
            "type": "keyword",
            "ignore_above": 256
          }
        }
      },
      "resource": {
        "type": "text",
        "fields": {
          "keyword": {
            "type": "keyword",
            "ignore_above": 256
          }
        }},"time": {"type": "long","fields": {"keyword": {"type": "keyword","ignore_above": 256}}},"user": {"type": "text","fields": {"keyword": {"type": "keyword","ignore_above": 256}}}}}}'



echo 'End'

sleep 20

echo '........'
curl -X POST "http://localhost:5601/api/saved_objects/_import" -H "kbn-xsrf: true" --form file=@export.ndjson

docker-compose -f  docker-compose-monitoring-connector.yaml  -f docker-compose-monitoring-stack.yaml -f docker-compose-monitoring-target.yaml up -d  logstash example-app