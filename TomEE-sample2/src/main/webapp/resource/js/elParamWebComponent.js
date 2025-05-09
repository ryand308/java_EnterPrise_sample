class HeaderComponent extends HTMLElement {
	
	connectedCallback() {
		this.innerHTML = '<p>Loading...</p>'; // 加載指示器
		// javascript 是尋找客戶端的資料
		fetch('component/header.html')
		.then(resp => resp.text()) // text() 把檔案的資料轉換成字串
		.then(html => this.innerHTML = html);

	}
}

customElements.define("app-header", HeaderComponent);

class ElParamFormComponent extends HTMLElement {
	
	connectedCallback() {
		fetch('component/elParamForm.html')
		.then(resp => resp.text())
		.then(html => this.innerHTML = html);
	}
}

customElements.define("app-hero", ElParamFormComponent);

class FooterComponent extends HTMLElement {
	
	connectedCallback() {
		fetch('component/footer.html')
		.then(resp => resp.text())
		.then(html => this.innerHTML = html);
	}
}

customElements.define("app-footer", FooterComponent);