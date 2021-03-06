(function() {
    'use strict';
    angular
        .module('app')
        .factory('Info', Info);

    Info.$inject = ['$resource'];

    function Info ($resource) {
        var resourceUrl =  'http://localhost:8080/drools2/package/setPackages';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                    }
                    return data;
                }
            },
            'update': { method:'PUT' },
			'save' : { method: 'POST', headers: { 'Access-Control-Allow-Origin': '*' }}
        });
    }
})();
