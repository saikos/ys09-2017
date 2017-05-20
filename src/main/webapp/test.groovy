import gr.uoa.di.ys09.*

html.html {
	head {
		meta('http-equiv':"Content-Type", 'content':"text/html; charset=utf-8")
		title("Groovy App Home")
	}
	body {
		div {
			img(src:"./static/logo.png")
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
			div("Πλήθος: ${numbers.count()} αριθμοί")
			div("Άθροισμα: ${numbers.sum()}")
		}
	}
}