get('/') {
   render('index.html')
}


get('/lookup') {
	render('artist.html')
}

post('/lookup') { request, response ->
	def url = new URL("http://musicbrainz.org/ws/2/artist?query=${request.form.artist[0]}")
	def metadata = new XmlSlurper().parseText(url.text)
	def artistList = metadata.'artist-list'.artist.name

	render('artist.html', artists: artistList)
}

