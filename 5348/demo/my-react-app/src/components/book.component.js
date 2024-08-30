import React, { Component } from "react";
import BookDataService from "../services/book.service";
import { withRouter } from '../common/with-router';

class Book extends Component {
    constructor(props) {
        super(props);
        this.onChangeTitle = this.onChangeTitle.bind(this);
        this.onChangeDescription = this.onChangeDescription.bind(this);
        this.onChangeStock = this.onChangeStock.bind(this);
        this.getBook = this.getBook.bind(this);
        this.updateBook = this.updateBook.bind(this);
        this.deleteBook = this.deleteBook.bind(this);

        this.state = {
            currentBook: {
                id: null,
                title: "",
                description: "",
                stock: 0
            },
            message: ""
        };
    }

    componentDidMount() {
        this.getBook(this.props.router.params.id);
    }

    onChangeTitle(e) {
        const title = e.target.value;

        this.setState(function(prevState) {
            return {
                currentBook: {
                    ...prevState.currentBook,
                    title: title
                }
            };
        });
    }

    onChangeDescription(e) {
        const description = e.target.value;

        this.setState(prevState => ({
            currentBook: {
                ...prevState.currentBook,
                description: description
            }
        }));
    }

    onChangeStock(e) {
        const stock = e.target.value;

        this.setState(prevState => ({
            currentBook: {
                ...prevState.currentBook,
                stock: stock
            }
        }));
    }

    getBook(id) {
        BookDataService.get(id)
            .then(response => {
                this.setState({
                    currentBook: response.data
                });
                console.log(response.data);
            })
            .catch(e => {
                console.log(e);
            });
    }

    updateBook() {
        BookDataService.update(
            this.state.currentBook.id,
            this.state.currentBook
        )
            .then(response => {
                console.log(response.data);
                this.setState({
                    message: "The book was updated successfully!"
                });
            })
            .catch(e => {
                console.log(e);
            });
    }

    deleteBook() {
        BookDataService.delete(this.state.currentBook.id)
            .then(response => {
                console.log(response.data);
                this.props.router.navigate('/books');
            })
            .catch(e => {
                console.log(e);
            });
    }

    render() {
        const { currentBook } = this.state;

        return (
            <div>
                {currentBook ? (
                    <div className="edit-form">
                        <h4>Book</h4>
                        <form>
                            <div className="form-group">
                                <label htmlFor="title">Title</label>
                                <input
                                    type="text"
                                    className="form-control"
                                    id="title"
                                    value={currentBook.title}
                                    onChange={this.onChangeTitle}
                                />
                            </div>
                            <div className="form-group">
                                <label htmlFor="description">Description</label>
                                <input
                                    type="text"
                                    className="form-control"
                                    id="description"
                                    value={currentBook.description}
                                    onChange={this.onChangeDescription}
                                />
                            </div>

                            <div className="form-group">
                                <label htmlFor="description">Stock</label>
                                <input
                                    type="number"
                                    className="form-control"
                                    id="stock"
                                    value={currentBook.stock}
                                    onChange={this.onChangeStock}
                                />
                            </div>
                        </form>


                        <button
                            className="btn btn-outline-secondary"
                            onClick={this.deleteBook}
                        >
                            Delete
                        </button>

                        <button
                            type="submit"
                            className="btn btn-outline-secondary"
                            onClick={this.updateBook}
                        >
                            Update
                        </button>
                        <p>{this.state.message}</p>
                    </div>
                ) : (
                    <div>
                        <br />
                        <p>Please click on a Book...</p>
                    </div>
                )}
            </div>
        );
    }
}

export default withRouter(Book);