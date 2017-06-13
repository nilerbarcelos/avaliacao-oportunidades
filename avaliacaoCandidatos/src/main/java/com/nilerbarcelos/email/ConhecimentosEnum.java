package com.nilerbarcelos.email;

public enum ConhecimentosEnum {

	HTML {
		@Override
		public String toString() {
			return "HTML";
		}
	},
	CSS {
		@Override
		public String toString() {
			return "CSS";
		}
	},
	JAVASCRIPT {
		@Override
		public String toString() {
			return "Javascript";
		}
	},
	PYTHON {
		@Override
		public String toString() {
			return "Python";
		}
	},
	DJANGO {
		@Override
		public String toString() {
			return "Django";
		}
	},
	IOS {
		@Override
		public String toString() {
			return "Desenvolvimento iOS";
		}
	},
	ANDROID {
		@Override
		public String toString() {
			return "Desenvolvimento Android";
		}
	}
}
