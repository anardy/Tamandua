module.exports = function(grunt){

	grunt.initConfig({
		jshint: {
			all: ['src/js/app.js']
		},
		uglify: {
			build: {
				files: {
					'src/js/app.min.js': ['src/js/app.js']
				}
			}
		},
	});

	grunt.loadNpmTasks('grunt-contrib-jshint');
	grunt.loadNpmTasks('grunt-contrib-uglify');
	grunt.registerTask('default', ['jshint', 'uglify']);

};
