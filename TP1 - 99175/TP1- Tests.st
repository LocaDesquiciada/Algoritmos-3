﻿TestCase subclass: #AlgoTripTest
	| algoTrip costoEsperado |

	algoTrip := AlgoTrip new.
	algoTrip agregarCiudad: 'Buenos Aires' dePais: 'Argentina' conCodigo: 'BUE' latitud: -34.60 longitud: -58.38.
	algoTrip crearViaje: 'vacaciones-2018'.
	algoTrip agregarVueloEnViaje: 'vacaciones-2018' de: 'BUE' a: 'COR' enFecha: '2018-6-1'.

	algoTrip solicitarComidaEspecialAbordoPara: 'vacaciones-2018'.

	costoEsperado := 645.97 + 100.
	self assert: ((algoTrip obtenerCostoDelViaje: 'vacaciones-2018') closeTo: costoEsperado precision: 0.001).
	! !
	| algoTrip costoEsperado |
	
	algoTrip := AlgoTrip new.
	algoTrip agregarCiudad: 'Buenos Aires' dePais: 'Argentina' conCodigo: 'BUE' latitud: -34.60 longitud: -58.38.
	algoTrip agregarCiudad: 'Rio' dePais: 'Brasil' conCodigo: 'RIO' latitud: -22.90 longitud: -43.19.
	algoTrip crearViaje: 'vacaciones-2018'.

	costoEsperado:= 1966.7 * 1.5 * 1.05.
	self assert: (algoTrip obtenerDuracionEnDiasDelViaje: 'vacaciones-2018') equals: 1.
	| algoTrip costoEsperado costoVuelos costoHotel |

	algoTrip := AlgoTrip new.
	algoTrip agregarCiudad: 'Moscu' dePais: 'Rusia' conCodigo: 'MOW' latitud: 55.75 longitud: 37.62.
	algoTrip agregarHotel: 'Matreshka Hotel' en: 'MOW' conPrecioPorNoche: 3000.

	self assert: ((algoTrip obtenerCostoDelViaje: 'vacaciones-2018') closeTo: costoEsperado precision: 0.001).
	| algoTrip |
	
	algoTrip := AlgoTrip new.
	algoTrip crearViaje: 'vacaciones-2018'.
	! !
	| algoTrip costoEsperado |

	costoEsperado := 2 * (1966.7 * 1.5 * 1.05).
! !
	| algoTrip costoEsperado |

	algoTrip := AlgoTrip new.
	algoTrip agregarCiudad: 'Rio' dePais: 'Brasil' conCodigo: 'RIO' latitud: -22.90 longitud: -43.19.
	algoTrip agregarHotel: 'Copacabana Palace' en: 'RIO' conPrecioPorNoche: 3000.
	algoTrip crearViaje: 'vacaciones-2018'.
	
	self assert: (algoTrip obtenerDuracionEnDiasDelViaje: 'vacaciones-2018') equals: 7.
	| algoTrip costoEsperado |
	
	algoTrip := AlgoTrip new.
	algoTrip agregarCiudad: 'Buenos Aires' dePais: 'Argentina' conCodigo: 'BUE' latitud: -34.60 longitud: -58.38.
	algoTrip agregarCiudad: 'Cordoba' dePais: 'Argentina' conCodigo: 'COR' latitud: -31.42 longitud: -64.18.
	algoTrip crearViaje: 'vacaciones-2018'.
	algoTrip agregarVueloEnViaje: 'vacaciones-2018' de: 'BUE' a: 'COR' enFecha: '2018-6-1'.
	" Costo: 1 peso por km para vuelos domesticos. La distancia se calcula con la formula del haversine. "
	" Duracion del viaje es un dia (el 1 de Junio que estamos volando). "
! !