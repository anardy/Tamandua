module.exports = function(grunt){

	grunt.initConfig({
		jshint: {
			all: ['src/js/correntista.js','src/js/funcionario.js','src/js/login.js','src/js/util.js']
		},
		uglify: {
			build: {
				files: {
					'src/js/correntista.min.js': ['src/js/correntista.js'],
					'src/js/funcionario.min.js': ['src/js/funcionario.js'],
					'src/js/login.min.js': ['src/js/login.js'],
					'src/js/util.min.js': ['src/js/util.js']
				}
			}
		},
	});

	grunt.loadNpmTasks('grunt-contrib-jshint');
	grunt.loadNpmTasks('grunt-contrib-uglify');
	grunt.registerTask('default', ['jshint', 'uglify']);

};
