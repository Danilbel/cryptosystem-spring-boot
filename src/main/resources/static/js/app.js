$(document).ready(function() {
    //////////////////////////////////
    const fileInput = $('#file-input');
    const fileContent = $('#file-content');
    const createNew = $('#create-new');
    const downloadFile = $('#download-file');
    const buttonResult = $('#button-result');
    //////////////////////////////////

    // Функция проверяет, должны ли кнопки быть активными
    function checkButtons() {
        let content = fileContent.val();
        if (content === "") {
            createNew.addClass("disabled");
            buttonResult.addClass("disabled");
            downloadFile.addClass("disabled");
        } else {
            createNew.removeClass("disabled");
            buttonResult.removeClass("disabled");
            downloadFile.removeClass("disabled");
        }
    }

    // Обработчик события изменения содержимого файла
    fileInput.on('change', function(e) {
        let file = e.target.files[0];
        if (file) {
            let reader = new FileReader();
            reader.onload = function() {
                let fileContentText = reader.result;
                fileContent.val(fileContentText);
                checkButtons();
            }
            reader.readAsText(file);
        }
    });

    // Обработчик события клика на кнопку "Создать новый"
    createNew.click(function() {
        fileContent.val('');
        checkButtons();
    });

    // Обработчик события клика на кнопку "Сохранить"
    downloadFile.click(function() {
        let content = fileContent.val();
        let blob = new Blob([content], {type: "text/plain;charset=utf-8"});
        let link = document.createElement("a");
        link.download = "file.txt";
        link.href = URL.createObjectURL(blob);
        document.body.appendChild(link);
        link.click();
        document.body.removeChild(link);
    });

    // Обработчик события клика на кнопку "Зашифровать/Расшифровать"
    buttonResult.click(function(event) {
        if ($(this).hasClass("disabled")) {
            event.preventDefault();
        }
    });

    // Обработчик события изменения содержимого текстового поля
    fileContent.on("input", function() {
        checkButtons();
    });

    // При загрузке страницы проверяем, должны ли кнопки быть активными
    checkButtons();
});

