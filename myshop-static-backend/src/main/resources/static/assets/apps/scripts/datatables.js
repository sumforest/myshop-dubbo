let Datatables = function () {

    let initTable = function (url,columns) {
        let table = $('#dataTables');
        let oTable = table.dataTable({
            "paging":true,
            "info":true,
            "lengthChange": false,
            "ordering":  false,
            "processing": true,
            "searching": false,
            "serverSide": true,
            "deferRender": true,
            "orderCellsTop": false,
            "autoWidth": false, // disable fixed width and enable fluid table
            "ajax": {
                "url": url
            },
            "columns":columns,
            language: {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            },

            "lengthMenu": [
                [10, 15, 20, -1],
                [10, 15, 20, "All"] // change per page values here
            ],
        });
        return oTable;
    };

    return {

        //main function to initiate the module
        init: function () {

            if (!jQuery().dataTable) {
                return;
            }

        },
        initHandlerDateTable: function (url, columns) {
            return initTable(url, columns);
        }

    };

}();

jQuery(document).ready(function() {
    // Datatables.init();
});