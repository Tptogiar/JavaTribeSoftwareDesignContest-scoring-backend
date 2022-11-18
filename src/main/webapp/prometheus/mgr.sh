curl -X POST -g 'http://localhost:9090/api/v1/admin/tsdb/delete_series?match[]={__name__=~".+"}'

curl -X POST -g http://8.134.163.132:9090/api/v1/admin/tsdb/delete_series