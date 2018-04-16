class SellButton extends HTMLElement {
  constructor() {
    super();
  }
/*cuando el elemento sea insertado en el dom, este metodo
se dispara. Aqui es un sitio para escribir el html*/
  connectedCallback(){
    let shadowRoot = this.attachShadow({mode: 'open'})
    shadowRoot.innerHTML = `
      <style>
        :host {
          --orange: #e67e22;
          --space: 1.5em;
        }
        .btn-container {
          border: 2px dashed var(--orange);
          padding: var(--space);
          text-align:  center;
        }
        .btn {
          background-color: var(--orange);
          border: 0;
          border-radius: 5px;
          color: white;
          padding: var(--space);
          text-transform: uppercase;
        }
      </style>
      <div class="btn-container">
        <button class="btn">Mostrar marcas</button>
      </div>
    `
  }
}
window.customElements.define('sell-button', SellButton);
