import gr.uoa.di.ys09.*

html.html {
	head {
		meta('charset':'utf-8')
		meta('name':'viewport', 'content':'width=device-width, initial-scale=1.0')
        link('rel':'stylesheet', 'href':'static/css/bootstrap.min.css')  
		title("Groovy App Home")
	}
	body {
		div {
			img(src:"static/img/logo.png")
		}

		h1("Καλώς ήλθατε")

		h2("Configuration")
		Configuration.instance.properties.each { k, v ->
			div("$k: $v")
		}

		
		h2("Calculation")

		div {
			form(method:"get") {
				input(type:"text", name:"numbers", size:"48", placeholder:"Εισάγετε ακεραίους χωρισμένους με κόμμα")
				button(type:"submit", "Υπολογισμός")				
			}
		}		

		String inputNumbers = request.getParameter("numbers")		
		if (inputNumbers) {
			Numbers numbers = Numbers.parse(inputNumbers)

			hr()			
			div("Πληθάριθμος: ${numbers.count()}")
			div("Άθροισμα: ${numbers.sum()}")
		}
	}
}