# Lista que armazena todos os alunos
# Cada aluno será um dicionário
alunos = []

# Dicionário que indexa a matrícula e aponta para o índice na lista
indice_matricula = {}

def cadastrar_aluno():
    nome = input("Nome: ")

    # Validação da idade
    try:
        idade = int(input("Idade: "))
        if idade < 0:
            print("Idade não pode ser negativa!")
            return
    except ValueError:
        print("Idade inválida!")
        return

    matricula = input("Matrícula: ")

    # Verifica se a matrícula já existe
    if matricula in indice_matricula:
        print("Matrícula já cadastrada!")
        return

    # Cria o aluno como um dicionário
    aluno = {
        "nome": nome,
        "idade": idade,
        "matricula": matricula
    }

    # Adiciona na lista
    alunos.append(aluno)

    # Atualiza o índice da matrícula
    indice_matricula[matricula] = len(alunos) - 1

    print("Aluno cadastrado com sucesso!")


def buscar_aluno():
    matricula = input("Digite a matrícula: ")

    if matricula not in indice_matricula:
        print("Aluno não encontrado!")
        return

    indice = indice_matricula[matricula]
    aluno = alunos[indice]

    print("Nome:", aluno["nome"])
    print("Idade:", aluno["idade"])
    print("Matrícula:", aluno["matricula"])


def listar_alunos():
    if len(alunos) == 0:
        print("Nenhum aluno cadastrado!")
        return

    print("\n=== LISTA DE ALUNOS ===")

    for aluno in alunos:
        print("----------------------")
        print("Nome:", aluno["nome"])
        print("Idade:", aluno["idade"])
        print("Matrícula:", aluno["matricula"])


def remover_aluno():
    matricula = input("Digite a matrícula para remover: ")

    if matricula not in indice_matricula:
        print("Matrícula não encontrada!")
        return

    indice_remover = indice_matricula[matricula]

    # Remove o aluno da lista
    alunos.pop(indice_remover)

    # Remove a matrícula do índice
    del indice_matricula[matricula]

    # Atualiza os índices das matrículas restantes
    for i in range(indice_remover, len(alunos)):
        mat = alunos[i]["matricula"]
        indice_matricula[mat] = i

    print("Aluno removido com sucesso!")


def menu():
    while True:
        print("\n=== MENU ===")
        print("1 - Cadastrar aluno")
        print("2 - Buscar por matrícula")
        print("3 - Listar todos")
        print("4 - Remover por matrícula")
        print("0 - Sair")

        opcao = input("Escolha uma opção: ")

        if opcao == "1":
            cadastrar_aluno()
        elif opcao == "2":
            buscar_aluno()
        elif opcao == "3":
            listar_alunos()
        elif opcao == "4":
            remover_aluno()
        elif opcao == "0":
            print("Saindo do sistema...")
            break
        else:
            print("Opção inválida!")


# Início do programa
menu()
