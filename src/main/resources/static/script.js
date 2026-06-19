const API = "http://localhost:8080/livros";

async function carregarLivros() {

    const response = await fetch(API);

    const livros = await response.json();

    let html = "";

    livros.forEach(livro => {

        html += `
        <div class="livro">

            <h3>${livro.titulo}</h3>

            <p><strong>Autor:</strong> ${livro.autor}</p>

            <p>
                <strong>Status:</strong>
                ${livro.disponivel
                    ? "🟢 Disponível"
                    : "🔴 Emprestado"}
            </p>

            ${!livro.disponivel
                ? `<p><strong>Com:</strong> ${livro.emprestadoPara}</p>`
                : ""}

            <button onclick="emprestar(${livro.id})">
                Emprestar
            </button>

            <button onclick="devolver(${livro.id})">
                Devolver
            </button>

            <button onclick="verFila(${livro.id})">
                Ver Fila
            </button>

            <button onclick="excluir(${livro.id})">
                Excluir
            </button>

            <hr>

        </div>
        `;
    });

    document.getElementById(
        "listaLivros"
    ).innerHTML = html;
}

async function cadastrarLivro() {

    const titulo =
        document.getElementById("titulo").value;

    const autor =
        document.getElementById("autor").value;

    if (!titulo || !autor) {
        alert("Preencha todos os campos.");
        return;
    }

    await fetch(API, {

        method: "POST",

        headers: {
            "Content-Type":
                "application/json"
        },

        body: JSON.stringify({
            titulo,
            autor
        })
    });

    document.getElementById(
        "titulo").value = "";

    document.getElementById(
        "autor").value = "";

    carregarLivros();
}

async function emprestar(id) {

    const usuario =
        prompt("Digite o nome da pessoa:");

    if (!usuario) return;

    const response =
        await fetch(
            `${API}/emprestar/${id}?usuario=${encodeURIComponent(usuario)}`,
            {
                method: "PUT"
            }
        );

    alert(await response.text());

    carregarLivros();
}

async function devolver(id) {

    const response =
        await fetch(
            `${API}/devolver/${id}`,
            {
                method: "PUT"
            }
        );

    alert(await response.text());

    carregarLivros();
}

async function excluir(id) {

    if (!confirm("Deseja excluir este livro?")) {
        return;
    }

    await fetch(
        `${API}/${id}`,
        {
            method: "DELETE"
        }
    );

    carregarLivros();
}

async function verFila(id) {

    const response =
        await fetch(
            `${API}/fila/${id}`
        );

    const fila =
        await response.json();

    if (fila.length === 0) {

        alert("Fila vazia");

        return;
    }

    alert(
        "Fila de espera:\n\n" +
        fila.join("\n")
    );
}

carregarLivros();